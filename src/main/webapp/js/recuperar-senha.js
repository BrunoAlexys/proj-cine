function validateSenha() {
    var senha = document.getElementById('newPassword').value;
    var confirmarSenha = document.getElementById('confirmPassword').value;

    if (senha === "" || confirmarSenha === "") {
      alert('Por favor, preencha o campo de senhas.');
      return false; // Impede o envio do formulário
    }

    if (senha !== confirmarSenha) {
      alert('As senhas não coincidem.');
      return false; // Impede o envio do formulário
    }

    // Continue com o redirecionamento ou outras ações, se necessário
    window.location.href = 'cine?action=LoginFormBean';

    // Retorne false para impedir o envio do formulário
    return false;
}