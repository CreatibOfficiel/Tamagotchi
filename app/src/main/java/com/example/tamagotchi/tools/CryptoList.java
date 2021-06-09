package com.example.tamagotchi.tools;

public enum CryptoList {

    BTC("BTC"),
    ETH("ETH"),
    XRP("XRP"),
    BCH("BCH"),
    LTC("LTC"),
    USDT("USDT"),
    BNB("BNB"),
    DOGE("DOGE"),
    ADA("ADA"),
    DOT("DOT"),
    USDC("USDC"),
    UNI("UNI"),
    LINK("LINK"),
    ICP("ICP"),
    MATIC("MATIC"),
    XLM("XLM"),
    SOL("SOL"),
    BUSD("BUSD"),
    VET("VET"),
    ETC("ETC"),
    THETA("THETA"),
    WBTC("WBTC"),
    EOS("EOS"),
    TRX("TRX"),
    FIL("FIL"),
    AAVE("AAVE"),
    XMR("XMR");

    private String name;
    CryptoList(String name) {this.name= name;}
    public String getName() {return name;}
}