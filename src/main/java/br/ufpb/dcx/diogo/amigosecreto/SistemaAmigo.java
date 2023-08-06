package br.ufpb.dcx.diogo.amigosecreto;

import java.util.LinkedList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new LinkedList<>();
        this.amigos = new LinkedList<>();
    }

    public List<Amigo> getAmigos() {
        return this.amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaCadastradoException {
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        if (!this.amigos.contains(amigo)) {
            this.amigos.add(amigo);
        } else {
            throw new AmigoJaCadastradoException("Amigo de email " + emailAmigo + " já cadastrado anteriormente");
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
        throw new AmigoInexistenteException("Amigo de email " + emailAmigo + " não encontrado");
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
        List<Mensagem> mensagensAnonimas = new LinkedList<>();
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
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                amigo = a;
            }
        }
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo de email " + emailDaPessoa + " não encontrado");
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
            throw new AmigoInexistenteException("Amigo de email " + emailDaPessoa + " não encontrado");
        } else {
            if (amigo.getEmailAmigoSorteado() == null) {
                throw new AmigoNaoSorteadoException("Amigo secreto de " + emailDaPessoa + " ainda não foi sorteado");
            }
        }
        return amigo.getEmailAmigoSorteado();
    }

    public void sortear() throws AmigoInexistenteException {
        List<Amigo> amigosNaoSorteados = new LinkedList<>(this.amigos);
        for (Amigo a : this.amigos) {
            Amigo amigoSorteado = null;
            if (a.getEmailAmigoSorteado() == null) {
                int posicaoDaListaSorteada = (int) (Math.random() * amigosNaoSorteados.size());
                amigoSorteado = amigosNaoSorteados.get(posicaoDaListaSorteada);

                // Verifica se ele não tirou ele mesmo
                if (amigoSorteado.getEmail().equals(a.getEmail())) {
                    if (posicaoDaListaSorteada == (amigosNaoSorteados.size() - 1)) {
                        amigoSorteado = amigosNaoSorteados.get(posicaoDaListaSorteada - 1);
                    } else {
                        amigoSorteado = amigosNaoSorteados.get(posicaoDaListaSorteada + 1);
                    }
                }

            }
            if (amigoSorteado == null) {
                throw new AmigoInexistenteException("Amigo não encontrado");
            }
            a.setEmailAmigoSorteado(amigoSorteado.getEmail());
            amigosNaoSorteados.remove(amigoSorteado);
        }
    }

}
