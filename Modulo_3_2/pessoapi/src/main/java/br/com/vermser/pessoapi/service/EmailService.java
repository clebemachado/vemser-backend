package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSend;

    private Map<String, Object> getDados(PessoaDTO pessoaDTO, String body){
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("body", body);
        dados.put("email", from);
        dados.put("emailUser", pessoaDTO.getEmail());
        return dados;
    }

    public String getTemplate(Map<String, Object> dados)
            throws IOException, TemplateException {
        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private void enviarEmail(Map<String, Object> dados, String subject){
        MimeMessage mimeMessage = emailSend.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(new InternetAddress(from, " Informativo - DBC"));
            mimeMessageHelper.setTo(dados.get("emailUser").toString());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(getTemplate(dados), true);

            emailSend.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendCreatePessoa(PessoaDTO pessoaDTO) {
        String body = "Seu cadastro foi realizado com sucesso, seu identificador sera "
                + pessoaDTO.getIdPessoa();
        enviarEmail(getDados(pessoaDTO, body), "Cria????o de conta.");
    }

    public void sendAlterarPessoa(PessoaDTO pessoaDTO) {
        String body = "Seus dados foram alterados no nosso sistema.";
        enviarEmail(getDados(pessoaDTO, body), "Altera????o cadastral." );
    }

    public void sendExluirPessoa(PessoaDTO pessoaDTO) {
        String body = "Voc?? perdeu o acesso ao nosso sistema";
        enviarEmail(getDados(pessoaDTO, body), "Exclus??o de conta.");
    }

    public void sendCreateEndereco(PessoaDTO pessoaDTO, EnderecoDTO endereco) {
        String body = "Seu endere??o " + endereco.getLogradouro() + " foi criado.";
        enviarEmail(getDados(pessoaDTO, body), "Endereco criado." );
    }

    public void sendAlterarEndereco(PessoaDTO pessoa, EnderecoCreateDTO endereco, String enderecoAntigo) {

        if(!enderecoAntigo.equals(endereco.getLogradouro())){
            enderecoAntigo = "Seu endere??o " + enderecoAntigo + " foi atualizado para "
                    + endereco.getLogradouro()
                    +" em nossos sistema.";
        } else {
            enderecoAntigo += "Seu endere??o foi atualizado para foi atualizado em nossos sistema.";
        }
        enviarEmail(getDados(pessoa, enderecoAntigo), "Atualiza????o de endere??o.");
    }

    public void sendExluirEndereco(PessoaDTO pessoa, EnderecoEntity endereco) {
        String body = "Seu endere??o "+ endereco.getLogradouro() +" removido do nossos sistema.";
        enviarEmail(getDados(pessoa, body), "Exclus??o de endere??o.");
    }

}
