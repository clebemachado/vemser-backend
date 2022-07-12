package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.entity.Endereco;
import br.com.vermser.pessoapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.Subject;
import java.io.File;
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

    private void enviarEmailEndereco(String subject, String text, String email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSend.send(message);
    }

    private void enviarEmailPessoa(PessoaDTO pessoaDTO, String subject, String template){
        MimeMessage mimeMessage = emailSend.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(new InternetAddress(from, " Informativo - DBC"));
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(getTemplate(pessoaDTO, template), true);

            emailSend.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getTemplate(PessoaDTO pessoaDTO, String nomeTemplate)
            throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate(nomeTemplate);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendCreatePessoa(PessoaDTO pessoaDTO) {
        enviarEmailPessoa(pessoaDTO, "Criação de conta.", "email-template-create.ftl");
    }

    public void sendAlterarPessoa(PessoaDTO pessoaDTO) {
        enviarEmailPessoa(pessoaDTO, "Alteração cadastral.", "email-template-alter.ftl" );
    }

    public void sendExluirPessoa(PessoaDTO pessoaDTO) {
        enviarEmailPessoa(pessoaDTO, "Exclusão de conta.", "email-template-exclude.ftl");
    }

    public void sendCreateEndereco(Pessoa pessoa, EnderecoDTO endereco) {
        String body = "Olá " + pessoa.getNome() + "\n\n"
                + "Seu endereço " + endereco.getLogradouro() + " foi criado. \n\n"
                + "Qualquer dúvida é só contatar com o suporte pelo e-mail " + from;
        enviarEmailEndereco("Endereço criado", body, pessoa.getEmail());
    }

    public void sendAlterarEndereco(PessoaDTO pessoa, EnderecoCreateDTO endereco, String enderecoAntigo) {

        if(!enderecoAntigo.equals(endereco.getLogradouro())){
            enderecoAntigo += " foi atualizado para " + endereco.getLogradouro();
        } else {
            enderecoAntigo += " foi atualizado para ";
        }

        String body = "Olá " + pessoa.getNome() + "\n\n"
                + "Seu endereço "+ enderecoAntigo +" em nossos sistema. \n\n"
                + "Qualquer dúvida é só contatar com o suporte pelo e-mail " + from;

        enviarEmailEndereco("Endereço alterado", body, pessoa.getEmail());
    }

    public void sendExluirEndereco(PessoaDTO pessoa, Endereco endereco) {
        String body = "Olá " + pessoa.getNome() + "\n\n"
                + "Seu endereço "+ endereco.getLogradouro() +" removido do nossos sistema. \n\n"
                + "Qualquer dúvida é só contatar com o suporte pelo e-mail " + from;
        enviarEmailEndereco("Endereço excluido", body, pessoa.getEmail());
    }

}
