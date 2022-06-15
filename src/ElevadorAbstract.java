public interface ElevadorAbstract {

    public abstract void inicializa();
    public abstract void entra(int quantidadePessoas);
    public abstract void sai(int quantidadePessoas);
    public abstract void desce(int quantidadeAndares);
    public abstract void sobe(int quantidadeAndares);
}
