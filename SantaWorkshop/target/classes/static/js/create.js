function toggleForm() {
    const type = document.getElementById("createType").value;

    document.getElementById("giftForm").style.display =
        type === "gift" ? "block" : "none";

    document.getElementById("elfForm").style.display =
        type === "elf" ? "block" : "none";

    document.getElementById("deliveryForm").style.display =
        type === "delivery" ? "block" : "none";
}