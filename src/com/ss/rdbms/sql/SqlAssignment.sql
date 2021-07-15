-- 1.
-- How many copies of the book titled 'The Lost Tribe' are owned by the lirary branch
-- whose name is 'Sharpstown'
-- 
SELECT COALESCE(SUM(tbl_book_copies.noOfCopies), 0)
FROM library.tbl_book_copies
INNER JOIN tbl_book ON tbl_book_copies.bookId = tbl_book.bookId
INNER JOIN tbl_library_branch ON tbl_book_copies.branchId = tbl_library_branch.branchId
WHERE tbl_book.title = 'The Lost Tribe' AND tbl_library_branch.branchName = 'Sharpstown'

-- 2.
-- How many copies of the book titled 'The Lost Tribe' are owned by the lirary branch
-- whose name is 'Sharpstown'
-- 
SELECT tbl_book.title, tbl_book_copies.noOfCopies, tbl_library_branch.branchName
FROM library.tbl_book_copies
INNER JOIN tbl_book ON tbl_book_copies.bookId = tbl_book.bookId
INNER JOIN tbl_library_branch ON tbl_book_copies.branchId = tbl_library_branch.branchId
WHERE tbl_book.title = 'The Lost Tribe'


-- 3.
-- Retrieve the names of all borrowers who do not have any books checked out.
-- 
SELECT tbl_borrower.name
FROM tbl_book_loans
RIGHT JOIN tbl_borrower ON tbl_book_loans.cardNo = tbl_borrower.cardNo
WHERE tbl_book_loans.cardNo IS NULL


-- 4.
-- For each book that is loaned out from the 'Sharpstown' branch and whose DueDate is today
-- , retrieve the book title, the borrower's name, and the borrower's address.
-- 
SELECT title, name, address
FROM tbl_book_loans
INNER JOIN tbl_library_branch ON tbl_book_loans.branchId = tbl_library_branch.branchId
INNER JOIN tbl_book ON tbl_book.bookId = tbl_book_loans.bookId
INNER JOIN tbl_borrower ON tbl_borrower.cardNo = tbl_book_loans.cardNo
WHERE CONVERT(dueDate, DATE) = CONVERT(NOW(), DATE)
AND branchName = 'Sharpstown'


-- 5.
-- For each library branch, retrieve the branch name and the total number of books loaned
-- out from that branch
-- 
SELECT branchName, COUNT(branchName) AS numBooksLoaned
FROM tbl_book_loans
INNER JOIN tbl_library_branch ON tbl_book_loans.branchId = tbl_library_branch.branchId
GROUP BY branchName


-- 6.
-- Retrieve the names, addresses, and number of books checked out for all borrowers who
-- have more than five books checked out.
-- 
SELECT name, address, COUNT(name) AS numBooksChecked
FROM tbl_book_loans
INNER JOIN tbl_borrower ON tbl_borrower.cardNo = tbl_book_loans.cardNo
GROUP BY tbl_borrower.cardNo
HAVING COUNT(name) > 5


-- 7.
-- For each book authored by 'Stephen King', retrieve the title and the number of copies
-- owned by the library branch whose name is 'Central'
-- 
SELECT title, noOfCopies
FROM
	(SELECT bookId, title, authorName
	FROM tbl_book
	INNER JOIN tbl_author ON tbl_book.authId = tbl_author.authorId
	WHERE authorName = 'Stephen King') stephBooks
INNER JOIN tbl_book_copies ON tbl_book_copies.bookId = stephBooks.bookId
INNER JOIN tbl_library_branch ON tbl_library_branch.branchId = tbl_book_copies.branchId
WHERE branchName = 'Central'