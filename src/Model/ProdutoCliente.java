
package Model;

public class ProdutoCliente {
    
    	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BancoDados bancoDados = new BancoDados();
		bancoDados.conecta();
		if (bancoDados.estaConecatdo()) {
                  
		
                       bancoDados.editar(4,30-10);
                       bancoDados.listar();
		
		} else {		
			System.out.println("Banco N�O OK");}
		}
}
