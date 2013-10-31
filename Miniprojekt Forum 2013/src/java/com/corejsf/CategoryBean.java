/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Tobias
 */
@ManagedBean
@RequestScoped
public class CategoryBean implements Serializable {
    
    @Inject

    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
    }
    
}
