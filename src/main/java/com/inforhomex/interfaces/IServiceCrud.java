package com.inforhomex.interfaces;

import java.util.Set;

/**
*@author Fer Carraro
*@date 27/12/2019
*/

public interface IServiceCrud<T,ID>{
  public abstract Set<T> findAll();
  public abstract T findById(ID id);
  public abstract T save(T object);
  public abstract void delete(T object);
  public abstract void deleteById(ID id);
}
