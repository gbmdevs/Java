package br.com.kotlin.estudos.model.repository.financial

import br.com.kotlin.estudos.model.repository.financial.id.FixedExpenseId
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
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
    var dueDate: Date?

){}
