package br.com.cwi.treinamento.worldcupapi.web;

import java.util.List;

import br.com.cwi.treinamento.worldcupapi.domain.WorldCup;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface WorldCupApi {

    @ApiOperation(
            value = "Consultar as edições de Copas do Mundo.",
            notes = "Serviço para consulta de todas as edições de Copas do Mundo.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Consulta realizada com sucesso.")})
    List<WorldCup> getAll();

    @ApiOperation(
            value = "Consultar uma edição de Copa do Mundo.",
            notes = "Serviço para consulta de uma edição específica de Copas do Mundo.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Consulta realizada com sucesso."),
            @ApiResponse(code = 404, message = "Copa do Mundo não encontrada.")})
    WorldCup getByEdition(Integer edition);

    @ApiOperation(
            value = "Inserir uma edição de Copa do Mundo.",
            notes = "Serviço para inclusão de uma edição de Copa do Mundo.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Copa do Mundo inserida com sucesso.")})
    void create(WorldCup worldcup);
}
