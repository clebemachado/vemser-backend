import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");
        MongoCollection<Document> usuario = mongoDatabase.getCollection("javafy");
        // Nova pessoa

        Document novoUsuario =
                new Document("nome", "Mel")
                        .append("genero", "F")
                        .append("email", "mel@faker.com")
                        .append("playlist", Arrays.asList(
                                new Document()
                                        .append("nome", "Walk off the eath")
                                        .append("musicas", Arrays.asList(
                                                new Document()
                                                        .append("nome", "Who held on the longest" )
                                                        .append("disc_number", 1)
                                                        .append("popularity", 75)
                                                        .append("preview_url", null)
                                        ))
                        ));
        // Inserir o usuário
        // TODO - VER COMO GERA SEQUENCE NO MONGO DB
        System.out.println("--Inserindo usuário");
        usuario.insertOne(novoUsuario);

        Document updateUser = new Document("$set", new Document("genero", "M").append("nome","Mario"));

        System.out.println("--Atualizando usuario");
        usuario.updateOne(Filters.eq("nome", "Mel"), updateUser );

        System.out.println("Adicionando novaPlaylist playlist");
        Document newPlaylist = new Document()
                .append("nome", "Para ouvir corrent")
                .append("musicas", Arrays.asList());

        usuario.updateOne(
                Filters.eq("nome", "Mario"),
                Updates.addToSet("playlist", newPlaylist)
        );

        System.out.println("Deletando usuario do banco...");
        usuario.deleteOne(Filters.eq("nome", "Mario"));

        // Projeções
        System.out.println("\nProjeções só usuário");
        Bson filter = Filters.empty();
        Bson projectionUser = include("nome", "genero", "email");
        usuario.find(filter).projection(projectionUser).forEach(System.out::println);

        System.out.println("\nProjeções só playlist nome");
        Bson projectionPlaylist = include("playlist.nome");
        usuario.find(filter).projection(projectionPlaylist).forEach(System.out::println);

        System.out.println("\nProjeções playlist nome + array musica");
        Bson projectionPlaylistCompleta = include("playlist.nome");
        usuario.find(filter).projection(projectionPlaylistCompleta).forEach(System.out::println);

        System.out.println("\nProjeções  musicas nome");
        Bson projectionArrayMusica = include("playlist.musicas.name");
        usuario.find(filter).projection(projectionArrayMusica).forEach(System.out::println);

        System.out.println("Agregações");
        List<Bson> aggregation = new ArrayList<>();
        aggregation.add(Aggregates.unwind("$playlist"));
        aggregation.add(Aggregates.project(projectionPlaylistCompleta));
        usuario.aggregate(aggregation).forEach(System.out::println);

        System.out.println("\nQuantidade de usuários por gênero");
        usuario.aggregate(
                Arrays.asList(
                        match(Filters.empty()),
                        group("$genero", Accumulators.sum("Quantidade", 1))

                )
        ).forEach(System.out::println);


    }
}
