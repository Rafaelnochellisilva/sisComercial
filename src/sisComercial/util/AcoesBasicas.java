package sisComercial.util;

public interface AcoesBasicas <Tipo> {
	public void salvar(Tipo objeto);
	public void apagar(Tipo objeto);
	public void alterar(Tipo objeto);
}