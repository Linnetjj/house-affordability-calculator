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

    println("\n--- Sammanfattning ---")
    println("Inkomst: $income kr")
    println("Vuxna: $adults")
    println("Barn 0–10: $childrenYoung")
    println("Barn 10–20: $childrenOld")
    println("Sparat kapital: $savings kr")
    println("Andra inkomster: $otherIncome kr")
    println("Utgifter: $monthlyExpenses kr")
    println("Huspris: $housePrice kr")
}
