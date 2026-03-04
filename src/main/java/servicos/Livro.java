package servicos;

import static java.lang.Integer.parseInt;

public class Livro {
    private int idLivro;
    private static int contadorId = 0;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String isbn13;
    private int estoque;


    public Livro(){
        contadorId++;
        this.idLivro += contadorId;
        this.titulo = "null";
        this.autor = "null";
        this.anoPublicacao = 0;
        this.isbn13 = "null";
        this.estoque = 0;
    }

    public boolean setTitulo(String titulo){
        if(titulo.length() > 100 || titulo.length() == 0){
            return false;
        }
        this.titulo = titulo;
        return true;
    }

    public boolean setAutor(String autor){
        if(autor.length() > 100 || autor.length() == 0){
            return false;
        }
        this.autor = autor;
        return true;
    }

    public boolean setAnoPublicacao(int ano){
        if(ano <= 0){
            return false;
        }
        this.anoPublicacao = ano;
        return true;
    }

    public boolean setIsbn13(String isbn13){
        if(isbn13.length() != 13 && isbn13.length() != 17){
            return false;
        }

        String[] isbnArray = isbn13.split("");
        int[] isbnIntArray = new int[13];
        int auxiliar = 0;
        for(int i = 0; i < isbnArray.length; i++){
            if(!isbnArray[i].equals("-")){
                isbnIntArray[auxiliar] = parseInt(isbnArray[i]);
                auxiliar++;
            }
        }

        int digitoVerificador = 0;
        for(int i = 0; i < isbnIntArray.length - 1; i++){
            if(i % 2 == 0){
                digitoVerificador += isbnIntArray[i];
            }else{
                digitoVerificador += (isbnIntArray[i] * 3);
            }
        }

        digitoVerificador = 10 - (digitoVerificador % 10);
        if(digitoVerificador == isbnIntArray[12]){
            this.isbn13 = isbn13;
            return true;
        }else{
            return false;
        }
        // Fórmula: https://homepages.dcc.ufmg.br/~rodolfo/aedsi-2-12/TP1.pdf
    }

    public void setEstoque(int estoque, int operacao){
        switch (operacao){
            case 1:
                this.estoque += estoque;
                break;
            case 2:
                this.estoque -= estoque;

        }
    }

    // Inserir método de exclusão de usuário.

    public int getIdLivro(){
        return this.idLivro;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public int getAnoPublicacao(){
        return this.anoPublicacao;
    }

    public String getIsbn13(){
        return this.isbn13;
    }

    public int getEstoque(){
        return this.estoque;
    }
}