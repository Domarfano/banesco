/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancozacarias;

/**
 *
 * @author Zacarias
 */
public class Nododoble {
    public cliente inf;
    public Nododoble siguiente;
    public Nododoble prev;
    
    public Nododoble (cliente inf){
        this.inf = inf;
        siguiente = null;
        prev = null;
    }
}
