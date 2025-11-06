package com.mayowa.bitfit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDao {
    @Insert
    suspend fun insert(entry: EntryEntity)

    @Query("SELECT * FROM entries ORDER BY timestamp DESC")
    fun getAll(): Flow<List<EntryEntity>>

    @Query("SELECT SUM(amountMl) FROM entries")
    fun getTotalMl(): Flow<Long?>

    @Query("SELECT AVG(amountMl) FROM entries")
    fun getAvgMl(): Flow<Double?>
}
