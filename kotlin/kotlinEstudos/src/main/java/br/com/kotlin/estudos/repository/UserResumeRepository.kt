package br.com.kotlin.estudos.repository;

import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationRequest
import br.com.kotlin.estudos.model.dto.resumeOperation.ResumeOperationResponse
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UserResumeRepository {
    fun findPositionStockMarket(request: ResumeOperationRequest): List<ResumeOperationResponse>
}
