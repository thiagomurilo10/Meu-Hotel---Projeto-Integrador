$(document).ready(function () {
    // Seleciona o botão "Saiba Mais" pelo seu ID
    var saibaMaisBtn = $('#saiba-mais-btn');

    // Adiciona um evento de clique ao botão
    saibaMaisBtn.click(function (event) {
        // Impede que o link padrão funcione (evita que a página seja recarregada)
        event.preventDefault();

        // Obtém a posição vertical da seção de reserva
        var reservaSectionOffset = $('#reserva').offset().top;

        // Anima o scroll suave até a seção de reserva
        $('html, body').animate({
            scrollTop: reservaSectionOffset
        }, 1000); // A animação dura 1 segundo (1000 milissegundos)
    });

    // Seleciona o formulário de reserva no arquivo "reserva.html"
    var reservaForm = $('#reserva-form');

    // Adiciona um evento de envio ao formulário
    reservaForm.submit(function (event) {
        event.preventDefault();

        // Validação: Verifica se todos os campos obrigatórios estão preenchidos
        if (validateForm()) {
            showMessage("Reserva feita com sucesso!");
            reservaForm[0].reset(); // Limpa o formulário após o envio bem-sucedido
        }
    });

    function validateForm() {
        var nome = $('#nome').val();
        var email = $('#email').val();
        var dataEntrada = $('#data-entrada').val();
        var dataSaida = $('#data-saida').val();

        if (!nome || !email || !dataEntrada || !dataSaida) {
            showMessage("Todos os campos são obrigatórios. Preencha todos eles.");
            return false;
        }

        return true;
    }

    function showMessage(message) {
        // Cria um elemento de mensagem e adiciona ao formulário
        var messageElement = $('<div class="alert alert-info">' + message + '</div>');
        reservaForm.append(messageElement);

        // Remove a mensagem após alguns segundos (opcional)
        setTimeout(function () {
            messageElement.remove();
        }, 5000);
    }
});
