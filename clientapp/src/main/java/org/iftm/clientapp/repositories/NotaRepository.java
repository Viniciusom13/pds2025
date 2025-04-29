package org.iftm.clientapp.repositories;

import java.util.List;

import org.iftm.clientapp.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    
    // Consulta por valor exato
    public List<Nota> findByValor(Float valor);
    
    // Consulta por valor maior que
    public List<Nota> findByValorGreaterThan(Float valor);
    
    // Consulta por valor menor que
    public List<Nota> findByValorLessThan(Float valor);
    
    // Consulta por média final exata
    public List<Nota> findByMediaFinal(Float mediaFinal);
    
    // Consulta por média final maior que
    public List<Nota> findByMediaFinalGreaterThan(Float mediaFinal);
    
    // Consulta por média final entre valores
    public List<Nota> findByMediaFinalBetween(Float minMedia, Float maxMedia);
    
    // Consulta por valor entre
    public List<Nota> findByValorBetween(Float minValor, Float maxValor);

    public List<Nota> findByValorBetweenAndMediaFinalGreaterThan(float f, float g, float h);
}