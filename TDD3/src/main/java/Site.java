import java.util.ArrayList;
import java.util.List;

public class Site {

    private final List<Usuario> cadastrosDeUsuarios = new ArrayList<>();

    public void adicionarUsuario(String nome, String data, boolean prioritario, String cpf, int senha, String profissao){
        Usuario user = new Usuario(nome,data,prioritario,cpf,senha,profissao);
        if (user.getNome() != null && user.getDataNascimento() != null && user.getCpf() != 0 && senha != 0 && profissao != null){
            cadastrosDeUsuarios.add(user);
        }
    }

    public Usuario getUsuarioSite(String cpf){
        try {
            long cpfLong = Long.parseLong(cpf);
            for (Usuario cadastrosDeUsuario : cadastrosDeUsuarios) {
                if (cadastrosDeUsuario.getCpf() == cpfLong) {
                    return cadastrosDeUsuario;
                }
            }
        }
        catch (NumberFormatException e){
            return null;
        }
        return null;
    }

    public boolean usuarioPrioritario(String cpf){
        Usuario user =  getUsuarioSite(cpf);

        if (user == null){
            return false;
        }

        return user.isPrioritario();

    }

}
