package za.ac.cput.Repository;
/**
 * @author Aiden Wallace 222471174
 */

import za.ac.cput.Domain.Auction;

import java.util.List;

public interface IAuctionRepository {

    Auction create(Auction auction);
    Auction read(Long auctionID);
    Auction update(Auction auction);
    Boolean delete(Long auctionID);
    List<Auction> getAll();
}
