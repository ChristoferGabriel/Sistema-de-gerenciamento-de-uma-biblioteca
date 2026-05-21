package model;

import interfaces.Gerenciavel;

public abstract class ItemBiblioteca implements Gerenciavel{
    private int quantDisponivel, codigo;

    public ItemBiblioteca(int codigo, int quantDisponivel) {
        this.codigo = codigo;
        this.quantDisponivel = quantDisponivel;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public int getCodigo() {
        return codigo;
    }

}
