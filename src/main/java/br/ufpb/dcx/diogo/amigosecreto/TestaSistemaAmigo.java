package br.ufpb.dcx.diogo.amigosecreto;

public class TestaSistemaAmigo {

    public static void main(String[] args) {
        try {
            SistemaAmigo sistemaAmigo = new SistemaAmigo();

            sistemaAmigo.cadastraAmigo("José", "jose@gmail.com");
            sistemaAmigo.cadastraAmigo("Maria", "maria@gmail.com");

            Amigo jose = sistemaAmigo.pesquisaAmigo("jose@gmail.com");
            Amigo maria = sistemaAmigo.pesquisaAmigo("maria@gmail.com");

            jose.setEmailAmigoSorteado("maria@gmail.com");
            maria.setEmailAmigoSorteado("jose@gmail.com");

            sistemaAmigo.enviarMensagemParaAlguem("E agora José?", "N/A", "jose@gmail.com", true);
            sistemaAmigo.enviarMensagemParaAlguem("Ora pois Maria", "N/A", "maria@gmail.com", true);

            for (Mensagem m : sistemaAmigo.pesquisaMensagensAnonimas()) {
                System.out.println(m.getTextoCompletoAExibir());
            }

            if (jose.getEmailAmigoSorteado().equals("maria@gmail.com")) {
                System.out.println("OK");
            }

        } catch (AmigoJaCadastradoException | AmigoInexistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
