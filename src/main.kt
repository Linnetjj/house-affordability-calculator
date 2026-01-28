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

    // ---- Grunddata ----
    val taxRate = 0.30
    val childCostYoung = 4000
    val childCostOld = 6000

    val totalIncome = income + otherIncome
    val tax = totalIncome * taxRate

    val childrenCost =
        (childrenYoung * childCostYoung) +
        (childrenOld * childCostOld)

    val disposableIncome =
        totalIncome - tax - childrenCost - monthlyExpenses

    val loanAmount = housePrice - savings
    val totalPeople = adults + childrenYoung + childrenOld

    val interestRates = listOf(0.02, 0.04, 0.06, 0.08)

    println("\n--- Resultat per räntescenario ---")

    for (rate in interestRates) {
        val monthlyInterestCost = (loanAmount * rate) / 12
        val remainingAfterHousing = disposableIncome - monthlyInterestCost
        val remainingPerPerson = remainingAfterHousing / totalPeople
        val decision = if (remainingAfterHousing > 0) "JA" else "NEJ"

        println("\nRänta: ${(rate * 100).toInt()} %")
        println("Boendekostnad/mån: ${formatCurrency(monthlyInterestCost)}")
        println("Kvar efter boende: ${formatCurrency(remainingAfterHousing)}")
        println("Kvar per person: ${formatCurrency(remainingPerPerson)}")
        println("Klarar vi detta? $decision")
    }
}

fun formatCurrency(amount: Double): String {
    return "%,.0f kr".format(amount)
}
