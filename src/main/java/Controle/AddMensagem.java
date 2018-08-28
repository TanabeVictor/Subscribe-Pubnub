package Controle;

import Entidade.Mensagem;
import java.util.ArrayList;
import java.util.List;

public class AddMensagem {
    private List<Mensagem> mensagens = new ArrayList<>();
    Mensagem mensagem;
    
    public void addMessageList(int ID, String descricao, int value) {
    mensagem = new Mensagem(ID, descricao, value);
    this.mensagens.add(mensagem);}
    
    public String searchMessage(int ID){
    return "";}
    
}
