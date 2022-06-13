package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.adoffer.AdOffer;

import java.util.List;

/**
 * Сервис по работе с предложениями
 */
public interface AdOfferService {
    /**
     * Получить все предложения пользователя
     * @param profile профиль пользователя
     * @return список предложений
     */
    List<AdOffer> getOfferListByProfile(Profile profile);

    /**
     * Получить все предложения
     * @return список всех предложений
     */
    List<AdOffer> getAllOffers();

    /**
     * Получить предложение по Id
     * @param offerId Id предложения
     * @return предложение
     */
    AdOffer getOfferById(String offerId);

    /**
     * Создать предложение
     * @param offer новое предложение
     * @return Id предложения
     */
    String createOffer(AdOffer offer);

    /**
     * Удалить предложение по Id
     * @param offerId Id предложения
     */
    void deleteOffer(String offerId);

    /**
     * Обновить предложение по Id
     * @param offerId Id предложения
     * @param newOffer измененное предложение
     */
    void updateOffer(String offerId, AdOffer newOffer);
}
