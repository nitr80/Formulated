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
import com.egeozturk.formulaappv04.converter.Converters;
import com.egeozturk.formulaappv04.model.FormulaListModel;
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
public final class FormulaListDao_Impl implements FormulaListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FormulaListModel> __insertionAdapterOfFormulaListModel;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<FormulaListModel> __deletionAdapterOfFormulaListModel;

  private final EntityDeletionOrUpdateAdapter<FormulaListModel> __updateAdapterOfFormulaListModel;

  public FormulaListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFormulaListModel = new EntityInsertionAdapter<FormulaListModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `FormulaListModel` (`listName`,`formulaIndexList`,`id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FormulaListModel value) {
        if (value.getListName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getListName());
        }
        final String _tmp = __converters.fromList(value.getFormulaIndexList());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
      }
    };
    this.__deletionAdapterOfFormulaListModel = new EntityDeletionOrUpdateAdapter<FormulaListModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `FormulaListModel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FormulaListModel value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfFormulaListModel = new EntityDeletionOrUpdateAdapter<FormulaListModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FormulaListModel` SET `listName` = ?,`formulaIndexList` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FormulaListModel value) {
        if (value.getListName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getListName());
        }
        final String _tmp = __converters.fromList(value.getFormulaIndexList());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertFormulaList(final FormulaListModel[] formulaList,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFormulaListModel.insert(formulaList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteFormulaList(final FormulaListModel[] formulaList,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFormulaListModel.handleMultiple(formulaList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateFormulaList(final FormulaListModel[] formulaList,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFormulaListModel.handleMultiple(formulaList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getFormulaLists(final Continuation<? super List<FormulaListModel>> continuation) {
    final String _sql = "SELECT * FROM FormulaListModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FormulaListModel>>() {
      @Override
      public List<FormulaListModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfListName = CursorUtil.getColumnIndexOrThrow(_cursor, "listName");
          final int _cursorIndexOfFormulaIndexList = CursorUtil.getColumnIndexOrThrow(_cursor, "formulaIndexList");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<FormulaListModel> _result = new ArrayList<FormulaListModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FormulaListModel _item;
            final String _tmpListName;
            if (_cursor.isNull(_cursorIndexOfListName)) {
              _tmpListName = null;
            } else {
              _tmpListName = _cursor.getString(_cursorIndexOfListName);
            }
            final List<Integer> _tmpFormulaIndexList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfFormulaIndexList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfFormulaIndexList);
            }
            _tmpFormulaIndexList = __converters.toList(_tmp);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item = new FormulaListModel(_tmpListName,_tmpFormulaIndexList,_tmpId);
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
  public Object getCurrentFormulaList(final int id,
      final Continuation<? super FormulaListModel> continuation) {
    final String _sql = "SELECT * FROM FormulaListModel WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FormulaListModel>() {
      @Override
      public FormulaListModel call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfListName = CursorUtil.getColumnIndexOrThrow(_cursor, "listName");
          final int _cursorIndexOfFormulaIndexList = CursorUtil.getColumnIndexOrThrow(_cursor, "formulaIndexList");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final FormulaListModel _result;
          if(_cursor.moveToFirst()) {
            final String _tmpListName;
            if (_cursor.isNull(_cursorIndexOfListName)) {
              _tmpListName = null;
            } else {
              _tmpListName = _cursor.getString(_cursorIndexOfListName);
            }
            final List<Integer> _tmpFormulaIndexList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfFormulaIndexList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfFormulaIndexList);
            }
            _tmpFormulaIndexList = __converters.toList(_tmp);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result = new FormulaListModel(_tmpListName,_tmpFormulaIndexList,_tmpId);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
