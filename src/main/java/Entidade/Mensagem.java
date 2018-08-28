package Entidade;

    public class Mensagem {

        String descricao;
        int ID, value;

    public Mensagem(int ID, String descricao, int value){
        this.ID = ID;
        this.descricao = descricao;
        this.value = value;}

    public void setID(int ID){
        this.ID = ID;}

    public void setDescricao(String descricao){
        this.descricao = descricao;}

    public void setValue(int value){
        this.value = value;}

    public int getID(){
        return this.ID;}
    
    public String getDescricao(){
        return this.descricao;}
    
    public int getValue(){
        return this.value;}}
