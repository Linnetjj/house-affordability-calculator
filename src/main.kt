fun main() {
    println("=== Housing Planner ===")

val income = readDouble("Ange total hushållsinkomst per månad (före skatt): ")
val adults = readInt("Ange antal vuxna i hushållet: ")
val childrenYoung = readInt("Ange antal barn (0–10 år): ")
val childrenOld = readInt("Ange antal barn (10–20 år): ")
val savings = readDouble("Ange sparat kapital (kontantinsats): ")
val otherIncome = readDouble("Ange andra inkomster per månad (bidrag, bonus): ")
val monthlyExpenses = readDouble("Ange månatliga utgifter (exkl. boende): ")
val housePrice = readDouble("Ange huspris: ")

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

fun readDouble(prompt: String): Double {
    while (true) {
        print(prompt)
        val input = readLine()
        try {
            return input!!.replace(",", ".").toDouble()
        } catch (e: Exception) {
            println("❌ Ogiltigt värde, försök igen.")
        }
    }
}

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val input = readLine()
        try {
            return input!!.toInt()
        } catch (e: Exception) {
            println("❌ Ogiltigt värde, försök igen.")
        }
    }
}
