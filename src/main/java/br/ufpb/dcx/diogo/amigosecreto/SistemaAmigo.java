package br.ufpb.dcx.diogo.amigosecreto;

import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {

    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        return new Amigo();
    }

    public void enviarMensagensParaTodos(String texto, String emailRemetente, boolean ehAnonima) {

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,
                                         String emailDestinatario, boolean ehAnonima) {

    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        return new List<Mensagem>;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new List<Mensagem>;
    }

    public void configuraAmigoSecreto(String emailDaPessoa, String emailAmigoSorteado) {

    }

    public void pesquisaAmigoSecreto(String emailDaPessoa) {

    }

}
