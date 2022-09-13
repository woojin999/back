document.getElementById('productRemove').addEventListener('click', (e) => {
  e.preventDefault();
  const pnoVal = document.getElementById('pnoVal').innerText;
  document.getElementById('pno').value = pnoVal;
  const delForm = document.getElementById('productRmForm');
  delForm.setAttribute('action', '/product/remove');
  delForm.submit();
});