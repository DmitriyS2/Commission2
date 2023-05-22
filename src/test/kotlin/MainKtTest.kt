import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun getCommissionWithMaestroMore75000() {
        val typeCard = "Maestro"
        val lastTransfer = 100000
        val transfer = 1000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(26, result)
    }

    @Test
    fun getCommissionWithMastercardMore75000() {
        val typeCard = "Mastercard"
        val lastTransfer = 200000
        val transfer = 5000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(50, result)
    }

    @Test
    fun getCommissionWithMaestroLess75000() {
        val typeCard = "Maestro"
        val lastTransfer = 5000
        val transfer = 1000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(0, result)
    }

    @Test
    fun getCommissionWithMastercardLess75000() {
        val typeCard = "Mastercard"
        val lastTransfer = 50000
        val transfer = 1000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(0, result)
    }

    @Test
    fun getCommissionWithVisaLess35() {
        val typeCard = "Visa"
        val lastTransfer = 100000
        val transfer = 1000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(35, result)
    }

    @Test
    fun getCommissionWithMirLess35() {
        val typeCard = "Мир"
        val lastTransfer = 100000
        val transfer = 500
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(35, result)
    }

    @Test
    fun getCommissionWithVisaMore35() {
        val typeCard = "Visa"
        val lastTransfer = 100000
        val transfer = 10000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(75, result)
    }

    @Test
    fun getCommissionWithMirMore35() {
        val typeCard = "Мир"
        val lastTransfer = 100000
        val transfer = 20000
        val result = getCommission(typeCard, lastTransfer, transfer)
        assertEquals(150, result)
    }

    @Test
    fun getCommissionWithoutCardAndLastTransfer() {
        val result = getCommission(transfer = 10000)
        assertEquals(10, result)
    }

}