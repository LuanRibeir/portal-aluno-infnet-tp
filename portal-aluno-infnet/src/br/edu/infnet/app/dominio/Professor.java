package br.edu.infnet.app.dominio;

public class Professor extends Pessoa{
    private String materia;
    private String turma;
    private float salario;
    private Boolean estagiario = false;

    public Professor(){
    }

    public Professor(String nome, String materia) {
        super(nome);
        this.materia = materia;
    }

    public Professor(String nome, String materia, String turma, float salario, Boolean estagiario) {
        super(nome);
        this.materia = materia;
        this.turma = turma;
        this.salario = salario;
        this.estagiario = estagiario;
    }

    public float calcularSalarioLiquido(){
        float x = estagiario ? 500 : 1500;
        float y = "java".equalsIgnoreCase(materia) ? 2000 : 700;

        return salario + x + y;
    }

    public String obterSituacao(){
        String situacao = estagiario ? "Sim" : "Não";
        return situacao;
    }

    @Override
    public void imprimir() {
        float salarioLiquido = calcularSalarioLiquido();

        try {
            System.out.printf("Nome: %s | Materia: %1s | Turma: %2s | Salário: %.1f | É estagiário: %3s \n",
                         super.getNome(), materia, turma, salarioLiquido, obterSituacao());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + " | " + materia + " | " + turma + " | " + salario + " | " + estagiario;
    }

    public String getMateria(){
        return materia;
    }
    public void setMateria(String materia){
        this.materia = materia;
    }

    public String getTurma(){
        return turma;
    }
    public void setTurma(String turma){
        this.turma = turma;
    }

    public float getSalario(){
        return salario;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }

    public Boolean getEstagiario(){
        return estagiario;
    }
    public void setEstagiario(Boolean estagiario){
        this.estagiario = estagiario;
    }
}
