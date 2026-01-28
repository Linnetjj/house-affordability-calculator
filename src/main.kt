fun main() {
    println("=== Housing Planner ===")

    print("Ange total hushållsinkomst per månad (före skatt): ")
    val income = readLine()!!.toDouble()

    print("Ange antal vuxna i hushållet: ")
    val adults = readLine()!!.toInt()

    print("Ange antal barn (0–10 år): ")
    val childrenYoung = readLine()!!.toInt()

    print("Ange antal barn (10–20 år): ")
    val childrenOld = readLine()!!.toInt()

    print("Ange sparat kapital (kontantinsats): ")
    val savings = readLine()!!.toDouble()

    print("Ange andra inkomster per månad (bidrag, bonus): ")
    val otherIncome = readLine()!!.toDouble()

    print("Ange månatliga utgifter (exkl. boende): ")
    val monthlyExpenses = readLine()!!.toDouble()

    print("Ange huspris: ")
    val housePrice = readLine()!!.toDouble()

    // ---- Ekonomisk logik ----

    val taxRate = 0.30
    val childCostYoung = 5000
    val childCostOld = 7000

    val totalIncome = income + otherIncome
    val tax = totalIncome * taxRate

    val childrenCost =
        (childrenYoung * childCostYoung) +
        (childrenOld * childCostOld)

    val disposableIncome =
        totalIncome - tax - childrenCost - monthlyExpenses

    val loanAmount = housePrice - savings

    println("\n--- Ekonomisk sammanfattning ---")
    println("Total inkomst: ${formatCurrency(totalIncome)}")
    println("Skatt (30 %): ${formatCurrency(tax)}")
    println("Barnkostnader: ${formatCurrency(childrenCost.toDouble())}")
    println("Disponibel inkomst före boende: ${formatCurrency(disposableIncome)}")
    println("Lånebelopp: ${formatCurrency(loanAmount)}")
}

// Hjälpfunktion för snygg utskrift
fun formatCurrency(amount: Double): String {
    return "%,.0f kr".format(amount)
}
