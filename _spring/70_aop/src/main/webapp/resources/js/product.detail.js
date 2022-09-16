document.getElementById('productRemove').addEventListener('click', (e) => {
  e.preventDefault();
  const pnoVal = document.getElementById('pnoVal').innerText;
  document.getElementById('pno').value = pnoVal;
  const delForm = document.getElementById('productRmForm');
  delForm.setAttribute('action', '/product/remove');
  delForm.submit();
});
document.addEventListener('click', (e) => {
  if (e.target.classList.contains("th_img")) {
      let modalZoneTag = document.getElementById('modalZone2');
      let thsrc = e.target.getAttribute("src").toString();
      let imgsrc = thsrc.replace("_th_", "_");
      console.log(imgsrc);
      modalZoneTag.innerHTML = `<img src="${imgsrc}" class="mx-auto d-block">`

      document.getElementById('modalBtn2').click();
  }
});
