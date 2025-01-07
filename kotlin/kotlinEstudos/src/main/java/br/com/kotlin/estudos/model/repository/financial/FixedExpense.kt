package br.com.kotlin.estudos.model.repository.financial

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name="FIXED_EXPENSE" ,  uniqueConstraints = [
    UniqueConstraint(columnNames = ["id", "type_fixed_id", "due_date"])
])
class FixedExpense(
    @Id
    @Column(name = "id",insertable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_fixed_id",referencedColumnName ="id")
    @JdbcTypeCode(SqlTypes.CHAR)
    var typeFixedExpense: TypeFixedExpense?,

    @JdbcTypeCode(SqlTypes.DATE)
    @Column(name="due_date")
    var dueDate: Date?,

    @Column(name="value_expense_actual")
    var valueExpenseActual: BigDecimal?

){}
