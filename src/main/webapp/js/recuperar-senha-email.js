 function validateForm() {
    var email = document.getElementById('emailInput').value;

    if (email === null) {
      alert('Por favor, preencha o campo de e-mail.');
      return false; // Impede o envio do formulário
    }

    // Continue com o redirecionamento ou outras ações, se necessário
    window.location.href = 'cine?action=RecuperarSenhaBean';

    // Retorne false para impedir o envio do formulário
    return false;
  }
  
