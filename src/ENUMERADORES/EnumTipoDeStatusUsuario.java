/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENUMERADORES;

/**
 *
 * @author roger
 */
public enum EnumTipoDeStatusUsuario {
    
    ATIVO, INATIVO;
    
    public static EnumTipoDeStatusUsuario getATIVO() {
        return ATIVO;
    }

    public static EnumTipoDeStatusUsuario getINATIVO() {
        return INATIVO;
    }
}
