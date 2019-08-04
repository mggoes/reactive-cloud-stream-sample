package br.com.sample.repository

import br.com.sample.model.PaymentDocument
import org.springframework.data.repository.reactive.ReactiveSortingRepository

interface PaymentRepository : ReactiveSortingRepository<PaymentDocument, String>