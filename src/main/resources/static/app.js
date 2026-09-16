const API_URL = "http://localhost:8080/api/palindromes";

// Charger l'historique au chargement de la page
document.addEventListener("DOMContentLoaded", chargerHistorique);

async function verifierPalindrome() {
    const input = document.getElementById("motInput");
    const resultatDiv = document.getElementById("resultat");
    const texte = input.value.trim();

    if (!texte) return;

    try {
        const response = await fetch(`${API_URL}/check?mot=${encodeURIComponent(texte)}`, {
            method: "POST"
        });

        if (!response.ok) throw new Error("Erreur réseau");

        const data = await response.json();

        resultatDiv.classList.remove("hidden", "succes", "echec");
        if (data.estPalindrome) {
            resultatDiv.classList.add("succes");
            resultatDiv.textContent = `"${data.texteOriginal}" est un palindrome !`;
        } else {
            resultatDiv.classList.add("echec");
            resultatDiv.textContent = `"${data.texteOriginal}" n'est pas un palindrome.`;
        }

        input.value = "";
        chargerHistorique();
    } catch (error) {
        console.error("Erreur lors de la vérification :", error);
    }
}

async function chargerHistorique() {
    const listeUl = document.getElementById("historiqueList");

    try {
        const response = await fetch(`${API_URL}/historique`);
        if (!response.ok) throw new Error("Erreur réseau");

        const historique = await response.json();
        listeUl.innerHTML = "";

        historique.forEach(item => {
            const li = document.createElement("li");
            const badge = item.estPalindrome ? "✅ Palindrome" : "❌ Non palindrome";
            li.innerHTML = `<span><strong>${item.texteOriginal}</strong></span> <span>${badge}</span>`;
            listeUl.appendChild(li);
        });
    } catch (error) {
        console.error("Erreur de chargement de l'historique :", error);
    }
}