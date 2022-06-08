
package View;

import Controller.BancoDados;
import Model.ItensProduto;
import java.sql.SQLException;
import Model.Produto;
import java.util.Scanner;
public class TestaVenda {
    
    	public static void main(String[] args) throws SQLException {
            Scanner teclado = new Scanner(System.in);


                Produto produto = new Produto();
                ItensProduto itens = new ItensProduto();
		BancoDados bancoDados = new BancoDados();
                
		bancoDados.conecta();
                
                
		if (bancoDados.estaConecatdo()) {
                    
                    
                    System.out.println("Lista de produtos:");
                    bancoDados.CarregarLista();
                    
                    System.out.println("Escolha um produto:");
                    int escolhaNum = teclado.nextInt();
                    
                    System.out.println("Adicionado ao carrinho!");
		     bancoDados.listar(escolhaNum);
                    System.out.println("Quantidade de compra: ");
		   int quantidade = teclado.nextInt();
                   
                   itens.setQtdVendida(quantidade); 
                   
                    bancoDados.editar(escolhaNum,quantidade);
                    
                    System.out.println("Estoque atual do produto!!");
                    bancoDados.listar(escolhaNum);
                    
		}
                
                else
                    
                {		
			System.out.println("Banco com defeito ");}
		}
}

        //bancoDados.inserir(produto);
        //bancoDados.editar(4,20);