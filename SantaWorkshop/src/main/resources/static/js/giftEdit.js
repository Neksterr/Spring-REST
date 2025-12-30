function enableEdit(button) {
    const row = button.closest(".gift-row");
    row.classList.add("editing");
}

function cancelEdit(button) {
    const row = button.closest(".gift-row");
    row.classList.remove("editing");
}

function saveEdit(button) {
    const row = button.closest(".gift-row");
    const id = row.dataset.id;

    const data = {
        name: row.querySelector(".name.edit").value,
        category: row.querySelector(".category.edit").value,
        targetAge: row.querySelector(".target-age.edit").value,
        status: row.querySelector(".status.edit").value
    };

    fetch(`/api/gifts/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    }).then(() => location.reload());
}
