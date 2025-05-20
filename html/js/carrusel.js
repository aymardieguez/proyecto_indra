const track = document.getElementById('track');
const eventos = document.querySelectorAll('.evento');
const btnPrev = document.getElementById('prevBtn');
const btnNext = document.getElementById('nextBtn');
let index = 0;

function moverCarrusel(direccion) {
  index = (index + direccion + eventos.length) % eventos.length;
  track.style.transform = `translateX(-${index * 100}%)`;
}

// Botones manuales
btnPrev.addEventListener('click', () => moverCarrusel(-1));
btnNext.addEventListener('click', () => moverCarrusel(1));

// Carrusel automático cada 5 segundos
setInterval(() => moverCarrusel(1), 5000);
