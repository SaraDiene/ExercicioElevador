import java.util.Scanner;
public class Elevador implements ElevadorAbstract {
    private boolean chamaElevador;
    private int andarAtual = 0;
    private int totalAndares = 10;
    private int capacidadeTotal = 6;
    private int quantidadePessoas = 0;
    public Elevador() {
        this.chamaElevador = true;
    }
    public int getAndarAtual() {
        return andarAtual;
    }
    public int getquantidadePessoas(){
        return quantidadePessoas;
    }

    public void inicializa(){
        if(this.chamaElevador == true && this.quantidadePessoas == 0 && this.andarAtual == 0){
            System.out.println("Porta do elevador aberta!");
            System.out.println("Estamos no térreo");
            System.out.println("Temos " + this.quantidadePessoas + " pessoas dentro do elevador");
        }   
    }
    public void entra(int quantidadePessoas) {
            if(this.quantidadePessoas >  this.capacidadeTotal){
                System.out.println("Capacidade total excedida");
            }
            else if(this.quantidadePessoas + quantidadePessoas > this.capacidadeTotal){
                System.out.println("Capacidade máxima " + this.capacidadeTotal + " pessoas");
            }
            else{
                this.quantidadePessoas = this.quantidadePessoas + quantidadePessoas;
                System.out.println("Temos " + this.quantidadePessoas + " pessoas dentro do elevador." );
            }
        }
    public void sai(int quantidadePessoas){
            if(this.quantidadePessoas <= 0){
                System.out.println("Não existem pessoas dentro do elevador");
            }
            else if((this.quantidadePessoas - quantidadePessoas) < 0){
                System.out.println("Temos somente " + this.quantidadePessoas + " pesosas dentro do elevador.");
            }
            else{
                this.quantidadePessoas = this.quantidadePessoas - quantidadePessoas;
                System.out.println("Saíram " + quantidadePessoas + " pessoas.");
                System.out.println("Temos " + this.quantidadePessoas + " pessoas dentro do elevador.");
            }
        }
    public void desce(int quantidadeAndares){
        if(this.andarAtual == 0){
            System.out.println("Estamos no térreo. Não é possível descer"); 
        }
        else if(this.andarAtual - quantidadeAndares < 0){
            System.out.println("Só é possível descer até o térreo.");
        }
        else{
            this.andarAtual = this.andarAtual - quantidadeAndares;
            System.out.println("Descendo...");
            System.out.println("Estamos no andar " + this.andarAtual);
        }
    }
    public void sobe(int quantidadeAndares) {
        if(this.andarAtual == this.totalAndares){
            System.out.println("Estamos no último andar, impossível subir.");
        }
        else if(this.andarAtual + quantidadeAndares > this.totalAndares){
            System.out.println("Só é possível subir até o décimo andar.");
        }
        else{
            this.andarAtual = this.andarAtual + quantidadeAndares;
            System.out.println("Subindo....");
            System.out.println("Estamos no andar " + this.andarAtual);
        }
    }
    public void mostrarInformacoes(){
        System.out.println("Quantidade de pessoas no elevador: " + this.quantidadePessoas);
        System.out.println("Andar atual: " + this.andarAtual);
    }
    static int chamarElevador(Scanner input){
        int opcao = -1;
        while(opcao != 0){
        System.out.print("Digite 0 para chamar o elevador: ");
        opcao = input.nextInt();
        }
        if(opcao == 0){
            Elevador elevador = new Elevador();
            elevador.inicializa();
            int iniciar = 0;
            while(iniciar < 5){
            System.out.println(" ");
            System.out.println("O que gostaria de fazer?");
            System.out.print("[1] Entrar no elevador\n[2] Sair do elevador\n[3] Subir\n[4] Descer\n[5] Encerrar programa");
            System.out.print("\nDigite a opção desejada: ");
            iniciar = input.nextInt();
            if(iniciar == 1){
                int quantidadePessoas;
                System.out.print("Quantas pessoas entrarão? ");
                quantidadePessoas = input.nextInt();
                elevador.entra(quantidadePessoas);
            }
            else if(iniciar == 2){
                int quantidadePessoas;
                if(elevador.getquantidadePessoas() == 0){
                    System.out.println("Temos " + elevador.getquantidadePessoas() + " pessoas dentro do elevador.");
                }
                else{
                System.out.print("Quantas pessoas sairão? ");
                quantidadePessoas = input.nextInt();
                elevador.sai(quantidadePessoas);
            }
            }
            else if(iniciar == 3){
                if(elevador.getquantidadePessoas() > 0){
                    int subirAndar;
                    if(elevador.getAndarAtual() == 10){
                        System.out.println("Estamos no último andar. Não é possível subir.");
                    }
                    else{
                    System.out.print("Quantos andares você quer subir? ");
                    subirAndar = input.nextInt();
                    elevador.sobe(subirAndar);
                    }
                }
                else{
                    System.out.println("Só é possível subir se houverem pessoas dentro do elevador");
                }

            }
            else if(iniciar == 4){
                if(elevador.getquantidadePessoas() > 0){

                    int descerAndar;
                    if(elevador.getAndarAtual() == 0){
                    System.out.println("Estamos no térreo. Não é possível descer.");
                    }
                    else{
                    System.out.print("Quantos andares você quer descer? ");
                    descerAndar = input.nextInt();
                    elevador.desce(descerAndar);
                    }   
                }
                else{
                    System.out.println("Só é possível descer se houverem pessoas dentro do elevador");
                }
            } 

        }
        System.out.println("ENCERRANDO PROGRAMA....");       
    }    
    return opcao;
}  
}
