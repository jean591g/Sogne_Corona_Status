/**
 * Asynkron proces der venter (await) til listen er læst inden den bliver vist
 */

(async () =>
{
    const sognTableBody = document.getElementById("sognTableBody");
    const sognForm = document.getElementById("sognForm");
    const sognListe = await getAllSogn();

    sognListe.forEach(sogn => {
        sognTableBody.innerHTML +=
            `
                <tr>
                    <td>${sogn.sognekode}</td>
                    <td>${sogn.navn}</td>
                    <td>${sogn.kommune.navn}</td>
                    <td>${sogn.smittetryk}%</td>
                    <td>${sogn.nedlukningStart}</td>
                </tr>
            `
    })

    sognForm.innerHTML +=
        `
            <form>
            <div class="form-group">
                <label>Sognekode</label><br>
                <input type="number" placeholder="indtast sognekode" id="sognekode">
            </div>
            <div class="form-group">
                <label>Sognenavn</label><br>
                <input type="text" placeholder="indtast sognenavn" id="sognenavn">
            </div>
            <div class="form-group">
                <label>Smittetryk</label><br>
                <input type="number" placeholder="indtast procentdel" id="smittetryk">
            </div>
            <div class="form-group">
                <label>Nedluknings dato</label><br>
                <input type="date" id="nedlukningsdato">
            </div>
            <div class="form-group">
                <label>Kommune navn</label><br>
                <input type="text" placeholder="indtast kommunenavn" id="kommune">
            </div>         
            <button type="submit" class="btn btn-info" id="saveSognButton">Gem</button>
            </form>
        `
    const saveSognButton = document.getElementById("saveSognButton");
    saveSognButton.addEventListener("click", saveSogn)
})()

async function saveSogn()
{
    const saveSognAPI = "/post";
    const postObject = {
        method:"POST",
        headers: {
            "Content-type": 'application/json',
        },
        body:JSON.stringify({
            "sognekode":document.getElementById("sognekode").value,
            "navn":document.getElementById("sognenavn").value,
            "smittetryk":document.getElementById("smittetryk").value,
            "nedlukningStart":document.getElementById("nedlukningsdato").value,
        })
    }

    await fetch(saveSognAPI,postObject);
    location.reload();
}

async function getAllSogn()
{
    const sognAPI = "/sogne";
    return await fetch(sognAPI).then(response => response.json());
}