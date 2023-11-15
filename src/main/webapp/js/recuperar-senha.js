 function validateSenha() {
    var senha = document.getElementById('newPassword').value;
    var confirmarSenha = document.getElementById('confirmPassword').value;

    if (senha === null && confirmarSenha === null) {
      alert('Por favor, preencha o campo de e-mail.');
      return false; // Impede o envio do formulário
    }

    // Continue com o redirecionamento ou outras ações, se necessário
    window.location.href = 'cine?action=#';

    // Retorne false para impedir o envio do formulário
    return false;
  }
