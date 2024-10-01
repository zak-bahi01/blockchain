package org.example;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import java.math.BigInteger;

public class ContractDeployment {
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20_000_000_000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private static final String PRIVATE_KEY = "0x08a35623d383d0a09a77b742a7e065112688d41b1482eeb0688f7ebb3d907fa6";
    
    public static void main(String[] args) throws Exception{
        // Adresse du nœud Ethereum en mode RPC
        String nodeUrl = "HTTP://127.0.0.1:7545";

        // Chargement du portefeuille
        Credentials credentials = Credentials.create(PRIVATE_KEY);

        // Création d'une instance Web3j
        Web3j web3j = Web3j.build(new HttpService(nodeUrl));

        // Deployer le contract
        VotingContract contract = VotingContract.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT).send();
        String contractAddress = contract.getContractAddress();
        System.out.println("Contrat déployé à l'adresse : " + contractAddress);

    }
}