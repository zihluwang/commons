package cn.vorbote.commons.consts;

/**
 * This is the list of supported JWT Hash Algorithms.
 */
public enum JwtAlgorithm {
    HS256, HS384, HS512,
    RS256, RS384, RS512,
    ES256, ES384, ES512,
    PS256, PS384;
}
