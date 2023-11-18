package com.egeozturk.formulaappv04.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FormulaLikeDao_Impl implements FormulaLikeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FormulaLikedModel> __insertionAdapterOfFormulaLikedModel;

  private final EntityDeletionOrUpdateAdapter<FormulaLikedModel> __deletionAdapterOfFormulaLikedModel;

  private final EntityDeletionOrUpdateAdapter<FormulaLikedModel> __updateAdapterOfFormulaLikedModel;

  public FormulaLikeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFormulaLikedModel = new EntityInsertionAdapter<FormulaLikedModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `FormulaLikedModel` (`isLiked`,`id`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FormulaLikedModel value) {
        final int _tmp = value.isLiked() ? 1 : 0;
        stmt.bindLong(1, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId());
        }
      }
    };
    this.__deletionAdapterOfFormulaLikedModel = new EntityDeletionOrUpdateAdapter<FormulaLikedModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `FormulaLikedModel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FormulaLikedModel value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfFormulaLikedModel = new EntityDeletionOrUpdateAdapter<FormulaLikedModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FormulaLikedModel` SET `isLiked` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FormulaLikedModel value) {
        final int _tmp = value.isLiked() ? 1 : 0;
        stmt.bindLong(1, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertFormulaLike(final FormulaLikedModel[] formulaLike,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFormulaLikedModel.insert(formulaLike);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteFormulaLike(final FormulaLikedModel[] formulaLike,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFormulaLikedModel.handleMultiple(formulaLike);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateFormulaLike(final FormulaLikedModel[] formulaLike,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFormulaLikedModel.handleMultiple(formulaLike);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllFormulaLikes(
      final Continuation<? super List<FormulaLikedModel>> continuation) {
    final String _sql = "SELECT * FROM FormulaLikedModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FormulaLikedModel>>() {
      @Override
      public List<FormulaLikedModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<FormulaLikedModel> _result = new ArrayList<FormulaLikedModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FormulaLikedModel _item;
            final boolean _tmpIsLiked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp != 0;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item = new FormulaLikedModel(_tmpIsLiked,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getOneFormulaLike(final int id, final Continuation<? super Boolean> continuation) {
    final String _sql = "SELECT isLiked FROM FormulaLikedModel WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getLikedFormulaIndex(final Continuation<? super List<Integer>> continuation) {
    final String _sql = "SELECT id FROM FormulaLikedModel WHERE isLiked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Integer>>() {
      @Override
      public List<Integer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Integer _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getInt(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
