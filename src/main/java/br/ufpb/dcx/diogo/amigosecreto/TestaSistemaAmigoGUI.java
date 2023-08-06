package br.ufpb.dcx.diogo.amigosecreto;

import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {

        try {
            SistemaAmigo sistemaAmigo = new SistemaAmigo();

            int qntParticipantes = Integer.parseInt(JOptionPane.showInputDialog("Quantos participantes?"));

            for (int i = 0; i < qntParticipantes; i++) {
                String nome = JOptionPane.showInputDialog("Qual o nome do participante?");
                String email = JOptionPane.showInputDialog("Qual o email do participante?");
                sistemaAmigo.cadastraAmigo(nome, email);
            }

            sistemaAmigo.sortear();

            for (Amigo a : sistemaAmigo.getAmigos()) {
                JOptionPane.showMessageDialog(null,
                        "Amigo secreto de " + a.getNome() + " é " + a.getEmailAmigoSorteado());
            }

            int posicaoDaListaSorteada = (int) (Math.random() * sistemaAmigo.getAmigos().size());
            Amigo amigoAEnviarMensagem = sistemaAmigo.getAmigos().get(posicaoDaListaSorteada);

            String texto = JOptionPane.showInputDialog("Digite a mensagem");
            String ehAnonimaStr = JOptionPane.showInputDialog("A mensagem é anônima? S/N");

            boolean ehAnonima = ehAnonimaStr.equalsIgnoreCase("S");

            Mensagem mensagem = new MensagemParaTodos(texto, amigoAEnviarMensagem.getEmail(), ehAnonima);

            JOptionPane.showMessageDialog(null, mensagem.getTextoCompletoAExibir());

        } catch (AmigoJaCadastradoException | AmigoInexistenteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
