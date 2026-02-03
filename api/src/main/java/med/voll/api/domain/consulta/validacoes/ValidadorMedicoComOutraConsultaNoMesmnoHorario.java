package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;


public class ValidadorMedicoComOutraConsultaNoMesmnoHorario {
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaMesmoHorario) {
            throw new RuntimeException("Médico já possui uma consulta nesse mesmo horário!");
        }
    }
}

