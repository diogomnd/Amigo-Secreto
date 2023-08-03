package br.ufpb.dcx.diogo.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaCadastradoException {
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        if (!this.amigos.contains(amigo)) {
            this.amigos.add(amigo);
        } else {
            throw new AmigoJaCadastradoException("Amigo já cadastrado anteriormente");
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        Amigo amigo;
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailAmigo)) {
                amigo = a;
                return amigo;
            }
        }
        throw new AmigoInexistenteException("Amigo não encontrado");
    }

    public void enviarMensagensParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,
                                         String emailDestinatario, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
            throws AmigoInexistenteException {

        Amigo amigo = null;
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {
                amigo = a;
                a.setEmailAmigoSorteado(emailAmigoSorteado);
            }
        }
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo não encontrado");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {

        Amigo amigo = null;
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {
                amigo = a;
            }
        }
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo não encontrado");
        } else {
            if (amigo.getEmailAmigoSorteado() == null) {
                throw new AmigoNaoSorteadoException("Amigo ainda não sorteado");
            }
        }
        return amigo.getEmailAmigoSorteado();
    }

}
